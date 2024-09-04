const https = require("https");
const express = require("express");
const bodyParser = require("body-parser");
const fs = require("fs");
const path = require("path");
const app = express();

app.use(bodyParser.json());
app.get("/", (req, res) => {
  console.log(req.body);
  res.send("Success");
});

const options = {
  key: fs.readFileSync(path.resolve(__dirname, "..", "key.pem"), "utf-8"),
  cert: fs.readFileSync(path.resolve(__dirname, "..", "cert.pem"), "utf-8"),
};

https.createServer(options, app).listen(8000, () => {
  console.log("Server is listening on https://localhost:8000");
});
