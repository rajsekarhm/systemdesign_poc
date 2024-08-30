import { sync } from "glob";
import hasteMap from "jest-haste-map";
import fs from "fs"
import { fileURLToPath } from "url";
import { dirname } from "path";
import { cpus, platform } from "os";
const root = dirname(fileURLToPath(import.meta.url));
const hasteMapOptions = {
  rootDir: root,
  roots: [root],
  maxWorker: cpus().length,
  platforms:[],
  extensions: ["js"],
  name: "inhouse-testing-library",
}
const haste = new hasteMap.default(hasteMapOptions);
const allFiles = sync("tests/*.js");
await haste.setupCachePath(hasteMapOptions);
const { hasteFS } = await haste.build();
// console.log(hasteFS.exists('tests/test4.js'))
const testFiles = hasteFS.matchFilesWithGlob(['**/*.js'])
console.log(testFiles)
for await(const testFile of testFiles){
  const result = await fs.promises.readFile(testFile,'utf-8')
  console.log(result)
}