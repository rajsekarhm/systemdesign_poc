const { mailServices } = require("../mailProperties");
const nodeMailer = require("nodemailer");
const {
  userMail,
  password,
  service: _service,
  host: _host,
  port: _port,
} = mailServices.testAccount;

console.log(_host, _port, userMail, password);
let transporter = nodeMailer.createTransport({
  host: _host,
  service: _service,
  secure: false,
  port: _port,
  auth: {
    user: userMail,
    pass: password,
  },
});

function sentMail(email, content) {
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
        console.log(err);
        reject(err);
      } else {
        resolve({ message: "Mail Sent Successfully", info: info });
      }
    });
  });
}

const _content = `<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Password Reset</title>
</head>
<body>
  <p>Dear [User's Name],</p>

  <p>We received a request to reset your account password. If you made this request, please click the link below to reset your password:</p>

  <p><a href="[Reset Link]" target="_blank" style="color: #1a73e8; text-decoration: none;">Reset My Password</a></p>

  <p>If you did not request a password reset, please ignore this email. Your password will remain unchanged.</p>

  <p>For security reasons, this link will expire in 24 hours.</p>

  <p>If you need further assistance, please contact our support team.</p>

  <p>Best regards,<br>
  [Your Company Name]</p>

  <hr>

  <p style="font-size: 12px; color: #777;">If you’re having trouble clicking the "Reset My Password" button, copy and paste the URL below into your web browser:</p>
  <p style="font-size: 12px; color: #777;">[Reset Link]</p>
</body>
</html>
`;

module.exports = {
  sentMail,
};
