import { sync } from "glob";
import hasteMap from "jest-haste-map";
const allFiles = sync("tests/*.js");

console.log(allFiles);
