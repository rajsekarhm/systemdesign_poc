const { service } = require("../mailProperties");
const nodeMailer = require("nodemailer");
const { userMail, password } = service.google;
let transporter = nodeMailer.createTransport({
  host: "smtp.gmail.com",
  service: "gmail",
  secure: true,
  port: 587,
  auth: {
    user: userMail,
    pass: password,
  },
});

export function sentMail(email, content) {
  return new Promise((resolve, reject) => {
    const mailOptions = {
      from: userMail,
      to: email,
      subject: "reset account password",
      html: content,
      priority: "high",
      attachments: [],
    };
    transporter.sendMail(mailOptions, (err, info) => {
      if (err) {
        reject(err);
      } else {
        resolve({ message: "Mail Sent Successfully", info: info });
      }
    });
  });
}
