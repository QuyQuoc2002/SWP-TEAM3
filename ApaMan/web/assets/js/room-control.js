const REGEX_NUMBER = '^[1-9][0-9]{0,6}$';
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
    let flagExist = false;
    let flagEmpty = false;
    let flagNegative = true;
    for (let i = 0; i < floorNames.length - 1; ++i) {
        if (floorNames[i].value.trim() === '') {
            flagEmpty = true;
            break;
        } 
        if (!floorNames[i].value.match(REGEX_NUMBER)){
            flagNegative = false;
            break;
        }
        for (let j = i + 1; j < floorNames.length; ++j) {
            if (floorNames[i].value === floorNames[j].value) {
                /*Tìm thấy 1 phần tử trùng là đủ và dừng vòng lặp*/
                flagExist = true;
                break;
            }
        }
    }
    if (flagEmpty) {
        showToast('warning', 'APAMAN Notification', 'Floor\'s name Empty');
    } else if (!flagNegative) {
        showToast('warning', 'APAMAN Notification', 'Floor\'s name must be positive number');
    } else if (flagExist) {
        showToast('warning', 'APAMAN Notification', 'Floor\'s name must be unique');
    } else {
        document.getElementById('update-floor-form').submit();
    }
}

function validateAddFloorName() {
    const floorName = document.getElementById('add-floor-name').value;
    if (floorName.trim() === '') {
        showToast('warning', 'APAMAN Notification', 'Floor\'s name Empty');
    } else if (!floorName.match(REGEX_NUMBER)) {
        showToast('warning', 'APAMAN Notification', 'Floor\'s name must be positive number');
    } else {
        document.getElementById('add-floor-form').submit();
    }
}

