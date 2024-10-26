import HasteMap, { IHasteFS } from "jest-haste-map";
import { cpus, platform } from "os";
import { Worker } from "jest-worker";
import {resolve} from "path";
import { getConfiguration } from "../utils/utils";
import { existsSync } from 'fs';
const {maxWorkers,rootDir,workerExecutorFile} = getConfiguration()
const root: string =rootDir;
const hasteMapOptions = {
  rootDir: root,
  roots: [root],
  maxWorkers: maxWorkers, 
  platforms: [],
  extensions: ["js"],
  name: "inhouse-testing-library",
};

const worker = new Worker(existsSync(workerExecutorFile) ? workerExecutorFile : resolve(root,'runner',"worker.js"), {
  enableWorkerThreads: true,
});

async function run(): Promise<void> {
  const haste: typeof HasteMap = new HasteMap(hasteMapOptions);
  console.log(haste)
  await haste.setupCachePath(hasteMapOptions);
  const { hasteFS }: { hasteFS: IHasteFS } = await haste.build();
  const testFiles: string[] | Set<String> = hasteFS.matchFilesWithGlob(["**/tests/**/*.js"]);
  console.log(testFiles)
  for await (const testFile of testFiles) {
    console.log(testFile);
    await worker.runFile(testFile);
  }
}

// Run the process and handle the end
run().finally(() => {
  worker.end();
});
