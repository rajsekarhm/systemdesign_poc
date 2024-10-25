const hasteMap = require("jest-haste-map");
const { cpus, platform } = require("os");
const { Worker } = require("jest-worker");
const path = require("path");
const { readFileSync } = require("fs");
const root = __dirname;
const hasteMapOptions = {
  rootDir: root,
  roots: [root],
  maxWorker: cpus().length,
  platforms: [],
  extensions: ["js"],
  name: "inhouse-testing-library",
};

const worker = new Worker(path.resolve(root, "worker.js"), {
  enableWorkerThreads: true,
});

async function run() {
  const haste = new hasteMap.default(hasteMapOptions);
  await haste.setupCachePath(hasteMapOptions);
  const { hasteFS } = await haste.build();
  const testFiles = hasteFS.matchFilesWithGlob(["**/tests/**/*.js"]);
  for await (const testFile of testFiles) {
    console.log(testFile);
    await worker.runFile(testFile);
  }
}

run().finally(() => {
  worker.end();
});
