module.exports = {
  presets: [
    [
      "@babel/preset-env",
      {
        targets: {
          node: "16",
        },
        modules: "cjs",
      },
    ],
    "@babel/preset-typescript",
  ],
  ignore: ["**/*.spec.ts", "**/*.test.ts",'**/core/tests/**'],
};
