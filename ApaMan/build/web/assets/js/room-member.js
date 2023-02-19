/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const REGEX_ROOM_NAME = '^[1-9][0-9]{2}[A-Z]{1}$';

function validateUpdateRoom() {
    const roomName = document.getElementById('add-name-room').value;
    if (roomName.trim() === '') {
        showToast('warning', 'APAMAN Notification', 'Room\'s name Empty');
    } else if (!roomName.match(REGEX_ROOM_NAME)) {
        showToast('warning', 'APAMAN Notification', 'Room\'s name is malformed (101A)');
    } else {
        document.getElementById('room-update').submit();
    }
}


