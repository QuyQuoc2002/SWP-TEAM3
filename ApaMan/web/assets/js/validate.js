const REGEX_PASSWORD = '^[a-zA-Z0-9!@#$%^&*,.]+$';
const REGEX_NAME = '^[a-zA-ZÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹý, ]+$';
const REGEX_ADDRESS = '^[a-zA-Z0-9,. ]+$';
const REGEX_EMAIL = '^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$';
const REGEX_MOBILE = '^[0-9]{10}$';
const REGEX_DATE = '(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})';

function validateHostInfo() {
    
    const accountUsername = document.getElementById("accountUsername").value;
    const accountPassword = document.getElementById("accountPassword").value;
    const apartmentName = document.getElementById("apartmentName").value;
    const hostName = document.getElementById("hostName").value;
    const hostMobile = document.getElementById("hostMobile").value;
    const apartmentAddress = document.getElementById("apartmentAddress").value;
    const districtId = document.getElementById("district").value;
    const latitude = document.querySelector('#map .latitude').value;
    const longitude = document.querySelector('#map .longitude').value;

    let errorStr = '<ol>';

    if (accountUsername.trim() === '') {
        errorStr += '<li>Please enter username</li>';
    } else if (!accountUsername.match(REGEX_EMAIL)) {
        errorStr += '<li>Username invalid</li>';
    }

    if (accountPassword.trim() === '') {
        errorStr += '<li>Please enter password</li>';
    } else if (!accountPassword.match(REGEX_PASSWORD)) {
        errorStr += '<li>Password invalid</li>';
    }

    if (apartmentName.trim() === '') {
        errorStr += '<li>Please enter apartment name</li>';
    } else if (!apartmentName.match(REGEX_ADDRESS)) {
        errorStr += '<li>apartment name invalid</li>';
    }
    
    if (hostName.trim() === '') {
        errorStr += '<li>Please enter host name</li>';
    } else if (!hostName.match(REGEX_NAME)) {
        errorStr += '<li>host name invalid</li>';
    }
    
    if (hostMobile.trim() === '') {
        errorStr += '<li>Please enter phone number</li>';
    } else if (!hostMobile.match(REGEX_MOBILE)) {
        errorStr += '<li>phone number invalid</li>';
    }
    
    if (apartmentAddress.trim() === '') {
        errorStr += '<li>Please enter apartment address</li>';
    } else if (!apartmentAddress.match(REGEX_ADDRESS)) {
        errorStr += '<li>apartment address invalid</li>';
    }
    
    if (districtId === '0') {
        errorStr += '<li>Please select district</li>';
    }
    
    if (latitude.trim() === '' || longitude.trim() === '') {
        errorStr += '<li>Please choose address on ggmap</li>';
    }
    errorStr += '</ol>';
    
    if (errorStr !== '<ol></ol>') {
        showToast('error', 'Error Validate', errorStr);
    } else {
        document.getElementById("submitType").value='Save';
        document.getElementById("hostAccountForm").submit();
    }
}

function validateNewStaffInfo() {
    
    const staffMobile = document.querySelector('#new-staff .phone-number').value;
    const staffName = document.querySelector('#new-staff .name').value;
    const staffJob = document.querySelector('#new-staff .job').value;

    let errorStr = '<ol>';
    
    if (staffMobile.trim() === '') {
        errorStr += '<li>Please enter phone number</li>';
    } else if (!staffMobile.match(REGEX_MOBILE)) {
        errorStr += '<li>phone number invalid</li>';
    }
    
    if (staffName.trim() === '') {
        errorStr += '<li>Please enter staff name</li>';
    } else if (!staffName.match(REGEX_NAME)) {
        errorStr += '<li>staff name invalid</li>';
    }
    
    if (staffJob.trim() === '') {
        errorStr += '<li>Please enter staff job</li>';
    } else if (!staffJob.match(REGEX_ADDRESS)) {
        errorStr += '<li>staff job invalid</li>';
    }
    
    errorStr += '</ol>';
    
    if (errorStr !== '<ol></ol>') {
        showToast("success", 'Error Validate', errorStr);
    } else {
        document.querySelector('#new-staff form').submit();
    }
}
