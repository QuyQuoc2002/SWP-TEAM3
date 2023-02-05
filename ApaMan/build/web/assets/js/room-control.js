document.getElementById('delete-floor-button-block').style.display = 'none';

function openConfirmDeleteFloor (floorId, floorName) {
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

