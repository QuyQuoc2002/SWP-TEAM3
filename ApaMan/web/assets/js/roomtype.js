
function checkRoomtypeNameExist() {
    alert(1);
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
    if (flag === 1) {
        showToast('error', 'APAMAN Notification', 'Roomtype\'s name is exist');
    } else {
        document.querySelector('#roomtype-add form').submit();
    }
}
