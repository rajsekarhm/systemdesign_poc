const net = require('net');
const fs = require('fs');
const path = require('path');

const server = net.createServer((socket) => {
  console.log('Client connected');
  
  const filePath = path.join(__dirname, 'received.txt');
  const fileStream = fs.createWriteStream(filePath);

  socket.on('data', (data) => {
    console.log('Receiving data...');
    fileStream.write(data); // Write the received data to the file
  });

  socket.on('end', () => {
    console.log('File received and saved.');
    fileStream.end(); // Close the file stream

    // Send a JSON response back to the client
    const response = JSON.stringify({ message: "File received successfully", status: "success" });
    socket.write(response, 'utf-8');
    socket.end(); // Optionally close the socket after sending the response
  });
});

server.listen(12345, () => {
  console.log('TCP server listening on port 12345');
});
