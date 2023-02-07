document.getElementById('delete-floor-button-block').style.display = 'none';

function openConfirmDeleteFloor(floorId, floorName) {
    document.getElementById('delete-floor-button-block').style.display = 'block';
    document.getElementById('update-floor-button-block').style.display = 'none';
    document.getElementById('floor-name-delete').innerText = floorName + ' ?';
    document.querySelector('#delete-floor-button-block a').href = 'floor-management?submitType=Delete&floorId=' + floorId;
}

function closeConfirmDeleteFloor() {
    document.getElementById('delete-floor-button-block').style.display = 'none';
    document.getElementById('update-floor-button-block').style.display = 'block';
    document.getElementById('floor-name-delete').innerText = '';
    document.querySelector('#delete-floor-button-block a').href = '';
}

function checkFloorNameDuplicate() {
    let floorNames = document.querySelectorAll('.floor-name');
    let flag = 0;
    for (let i = 0; i < floorNames.length - 1; ++i) {
        for (let j = i + 1; j < floorNames.length; ++j) {
            if (floorNames[i].value === floorNames[j].value) {
                /*Tìm thấy 1 phần tử trùng là đủ và dừng vòng lặp*/
                flag = 1;
                break;
            }
        }
    }
    if (flag === 1) {
        showToast('warning', 'APAMAN Notification', 'Floor\'s name must be unique');
    } else {
        document.getElementById('update-floor-form').submit();
    }
}
