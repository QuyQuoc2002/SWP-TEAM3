function resetStaff() {
    document.querySelector('#new-staff .countryside').value = null;
    document.querySelector('#new-staff .dob').value = null;
    document.querySelector('#new-staff .phone-number').value = null;
    document.querySelector('#new-staff .citizen-identification').value = null;
    document.querySelector('#new-staff .salary').value = null;
    document.querySelector('#new-staff .name').value = null;
    document.querySelector('#new-staff .job').value = null;
}

function confirmDeleteStaff(accountId, staffId, accountUsername) {
    document.getElementById('accoutUsernameDelete').innerText = accountUsername;
    document.getElementById('staffIdDelete').value = staffId;
    document.getElementById('accountIdDelete').value = accountId;
    openModal('modal-delete-account-staff');
}

