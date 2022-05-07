const input = document.querySelectorAll("input");
const newPasswordInput = input[0];
const reNewPasswordInput = input[1];
const submitBtn = document.querySelector("button");
const label = document.querySelectorAll("label");

let checkPasswordFlag = false;
let newPasswordCheckFlag = false;

submitBtn.disabled = true;


function isEmpty(str) {
	return str == null || str == "" || typeof str == "undefined";
}


function buttonFlag() {
	if (checkPasswordFlag && newPasswordCheckFlag) {
		submitBtn.disabled = false;
	} else {
		submitBtn.disabled = true;
	}
}


newPasswordInput.onblur = () => {
	if (newPasswordInput.value == reNewPasswordInput.value) {
		checkPasswordFlag = true;
		buttonFlag();
	} else {
		checkPasswordFlag = false;
		buttonFlag();
	}


	$.ajax({
		type: "post",
		url: "/gyeongun/profile/checkPassword",
		async: false,
		data: JSON.stringify({
			"newPassword": newPasswordInput.value
		}),
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		success: function(data) {
			if (data == "true" && newPasswordInput.value.length > 1) {
				checkPasswordFlag = true;
				alert("변경 가능한 비밀번호입니다.");
			} else if (data == "false") {
				alert("이전 사용했던 비밀번호는 사용할 수 없습니다.");
			}
		},
		error() {
			alert("비동기 통신 오류");
		}
	})
}



reNewPasswordInput.onblur = () => {
	if (newPasswordInput.value == reNewPasswordInput.value) {
		newPasswordCheckFlag = true;
		buttonFlag();
	}else {
		newPasswordCheckFlag = false;
		buttonFlag();
	}
}

submitBtn.onclick = () => {
	$.ajax({
		type: "post",
		url: "/gyeongun/profile/change_password",
		data: {
			"newPassword": newPasswordInput.value
		},
		dataType: "text",
		success(data) {
			if (data == "true") {
				alert("비밀번호가 변경되었습니다. 다시 로그인해주세요.");
				location.replace("/gyeongun/auth/signin");
			} else {
				alert("비밀번호 변경 실패");
			}
		},
		error() {
			alert("비동기 처리 오류");
		}
	})
}



