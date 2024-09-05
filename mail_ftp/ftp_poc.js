const express = require("express");
const fs = require("fs");
const path = require("path");
const app = express();
const serverIndex = require("serve-index");
app.use(
  "/getRemoteFiles",
  express.static("public"),
  serverIndex("public", { icons: true, hidden: true }),
);

app.listen(8080, () => {
  console.log("Listen");
});
