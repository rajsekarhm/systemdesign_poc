const { createTestAccount } = require("nodemailer");
module.exports = {
  mailServices: {
    google: {
      userMail: process.env.AUTH_USERNAME,
      password: process.env.AUTH_PASSWORD,
      host: "smtp.gmail.com",
      port: 587,
      service: "gmail",
    },
    testAccount: {
      userMail: "myron.vandervort7@ethereal.email",
      password: "6sp1NyZdchUgTmbsfb",
      host: "smtp.ethereal.mail",
      port: 587,
      service: "ethereal",
    },
  },
};
