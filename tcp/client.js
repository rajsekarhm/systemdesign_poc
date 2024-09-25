// const net = require('net');
// const fs = require('fs');
// const path = require('path');

// const client = net.createConnection({ port: 12345 }, () => {
//   console.log('Connected to server');
//   const filePath = path.join(__dirname, 'client.txt');
//   const fileStream = fs.createReadStream(filePath);
//   const chunks = []
//   fileStream.on('data',(chunk) => {
//     chunks.push(chunk)
//   })
//   /**
//    * alternative way to send data
//    */
// //   fileStream.on('open', () => {
// //     fileStream.pipe(client); // Pipe the file data directly to the server
// //   });
// client.write('ok','utf-8')
//   fileStream.on('end', () => {
//     client.write(Buffer.concat(chunks),'utf-8')
//     console.log('File sent successfully.');
//     client.end(); // Close the connection
//   });
// });

// client.on('end', () => {
//   console.log('Disconnected from server');
// });


const net = require('net');
const fs = require('fs');
const path = require('path');

const client = net.createConnection({ port: 12345 }, () => {
  console.log('Connected to server');

  const filePath = path.join(__dirname, 'client.txt');
  const fileStream = fs.createReadStream(filePath);

  // Send the file data to the server
  fileStream.on('open', () => {
    fileStream.pipe(client); // Pipe the file data directly to the server
  });

  fileStream.on('end', () => {
    console.log('File sent successfully.');
    client.end(); // Close the connection
  });
});

// Receive the server's response
client.on('data', (data) => {
  console.log('Received from server:', data.toString());
  // Parse JSON if that's what you expect
  const response = JSON.parse(data.toString());
  console.log('Parsed response:', response);
});

client.on('end', () => {
  console.log('Disconnected from server');
});
