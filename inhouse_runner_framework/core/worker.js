async function runFile(filePath) {
  try {
    require(filePath);
  } catch (err) {
    return err;
  }
}

module.exports = {
  runFile,
};
