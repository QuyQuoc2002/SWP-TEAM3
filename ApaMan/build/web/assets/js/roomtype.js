const REGEX_ROOMTYPE_NAME = '^[A-Z]{2}[0-9]{3}$';
const REGEX_NUMBER = '^[1-9][0-9]{0,9}$';
const REGEX_AREA = '^[1-9][0-9,. ]{0,9}$';

function validateAddRoomtype() {
    
    const roomtypeName = document.getElementById('add-roomtype-name').value;
    const roomtypeMaxMember = document.getElementById('add-roomtype-maxmember').value;
    const roomtypeCost = document.getElementById('add-roomtype-cost').value;
    const roomtypeArea = document.getElementById('add-roomtype-area').value;
    let roomtypeNames = document.querySelectorAll('.roomtype-name');
    let flag = 0;
    for (let i = 0; i < roomtypeNames.length - 1; ++i) {
        for (let j = i + 1; j < roomtypeNames.length; ++j) {
            if (roomtypeNames[i].value === roomtypeNames[j].value) {
                /*Tìm thấy 1 phần tử trùng là đủ và dừng vòng lặp*/
                flag = 1;
                break;
            }
        }
    }
    let errorStr = '<ol>';
    
    if (flag === 1) {
        errorStr += '<li>Roomtype\'s name is exist</li>';
    } 
    
    if (roomtypeName.trim() === '') {
        errorStr += '<li>Please enter roomtype\'s name</li>';
    } else if (!roomtypeName.match(REGEX_ROOMTYPE_NAME)) {
        errorStr += '<li>Roomtype\'s name is malformed (LP000)</li>';
    } 
    
    if (roomtypeMaxMember.trim() === '') {
        errorStr += '<li>Please enter max member</li>';
    } else if (!roomtypeMaxMember.match(REGEX_NUMBER)) {
        errorStr += '<li>Max member invalid</li>';
    }
    
    if (roomtypeCost.trim() === '') {
        errorStr += '<li>Please enter cost</li>';
    } else if (!roomtypeCost.match(REGEX_NUMBER)) {
        errorStr += '<li>Cost invalid</li>';
    }
    
    if (roomtypeArea.trim() === '') {
        errorStr += '<li>Please enter area</li>';
    } else if (!roomtypeArea.match(REGEX_AREA)) {
        errorStr += '<li>Area invalid</li>';
    }
    
    errorStr += '</ol>';
    
    if (errorStr !== '<ol></ol>') {
        showToast('error', 'APAMAN Notification', errorStr);
    } else {
        document.querySelector('#roomtype-add form').submit();
    }
    
}

function validateUpdateRoomtype() {
    const roomtypeName = document.getElementById('update-roomtype-name').value;
    const roomtypeMaxMember = document.getElementById('update-roomtype-maxmember').value;
    const roomtypeCost = document.getElementById('update-roomtype-cost').value;
    const roomtypeArea = document.getElementById('update-roomtype-area').value;
    
    
    let errorStr = '<ol>';
    
    if (roomtypeName.trim() === '') {
        errorStr += '<li>Please enter roomtype\'s name</li>';
    } else if (!roomtypeName.match(REGEX_ROOMTYPE_NAME)) {
        errorStr += '<li>Roomtype\'s name is malformed (LP000)</li>';
    } 
    
    if (roomtypeMaxMember.trim() === '') {
        errorStr += '<li>Please enter max member</li>';
    } else if (!roomtypeMaxMember.match(REGEX_NUMBER)) {
        errorStr += '<li>Max member invalid</li>';
    }
    
    if (roomtypeCost.trim() === '') {
        errorStr += '<li>Please enter cost</li>';
    } else if (!roomtypeCost.match(REGEX_NUMBER)) {
        errorStr += '<li>Cost invalid</li>';
    }
    
    if (roomtypeArea.trim() === '') {
        errorStr += '<li>Please enter area</li>';
    } else if (!roomtypeArea.match(REGEX_AREA)) {
        errorStr += '<li>Area invalid</li>';
    }
    
    errorStr += '</ol>';
    
    if (errorStr !== '<ol></ol>') {
        showToast('error', 'APAMAN Notification', errorStr);
    } else {
        document.getElementById("submitType").value='Update';
        document.querySelector('#roomtype-update form').submit();
    }
}




