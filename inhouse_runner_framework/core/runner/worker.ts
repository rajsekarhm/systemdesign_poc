import { readFileSync, existsSync } from "fs";
async function runFile(filePath:string):Promise<any> {
  try {
    return existsSync(filePath) && eval(readFileSync(filePath,'utf-8'));
  } catch (err) {
    return err;
  }
}

export { runFile };
