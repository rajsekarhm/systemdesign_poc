const nodeMailer = require("nodemailer");

// proton
// let transporter = nodemailer.createTransport({
  host: '127.0.0.1', // Use the local SMTP server provided by the Bridge
//   port: 1025,        // Use the port provided by the Bridge
//   secure: false,     // Use TLS, if available
//   auth: {
//     user: 'your-bridge-username', // The username provided by the Bridge
//     pass: 'your-bridge-password', // The password provided by the Bridge
//   },
// });
// google
// let transporter = nodeMailer.createTransport({
//   host: "smtp.gmail.com",
//   service: "gmail",
//   secure: true,
//   port: 587,
//   auth: {
//     user: process.env.FROM_MAIL_ADDRESS,
//     pass: process.env.FROM_MAIL_PASSWORD,
//   },
// });

export function sentMail(email, content) {
  return new Promise((resolve, reject) => {
    const mailOptions = {
      from: "support-drawanything <iplrating2018@gmail.com>",
      to: email,
      subject: "reset account password",
      html: content,
      priority: "high",
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
