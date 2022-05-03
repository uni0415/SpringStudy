const submitBtn = document.querySelector(".submit-btn");
const profileUsername = document.querySelector(".profile-username");
const passwordInputs = document.querySelectorAll(".password-input");
const originPassword = passwordInputs[0];
const newPassword = passwordInputs[1];
const newRePassword = passwordInputs[2];


let usercode = 0;

let principal = getPrincipal();

load();

function load() {
	const profileImg = profileImgRound.querySelector("img");
	profileUsername.textContent = principal.username;
	profileImg.src = getProfileImg();
}


equalPassword();

function passwordIsNull() {
	submitBtn.onclick = () => {
		if (!originPassword.value) {
			alert("이전 비밀번호를 입력해주세요");
		} else if (!newPassword.value) {
			alert("새 비밀번호를 입력해주세요");
		} else if (!newRePassword.value) {
			alert("새 비밀번호 확인을 입력해주세요");
		}
	}
}

function equalPassword() {
	newRePassword.onblur = () => {
		if (!(!originPassword.value || !newPassword.value || !newRePassword.value)) {
			if (originPassword.value == newPassword.value) {
				alert("새 비밀번호는 이전 비밀번호와 다른 값을 입력해주세요");
			}
			if (!(newPassword.value == newRePassword.value)) {
				alert("새 비밀번호와 새 비밀번호 확인 값이 다릅니다.")
			}
		}
	}
}


submitBtn.onclick = () => {
	passwordIsNull();
	$.ajax({
		type: "put",
		url: "/app/profile/account/password/update",
		async:false,
		data: {
			originPassword:originPassword.value,
			newPassword:newPassword.value
		},
		dataType:"text",
		success: function(data){
			if(data == "true"){
				alert("비밀번호 변경 완료");
			}
		},
		error: function(data){
			alert("비동기 처리 오류");
		}
		
	});
}






/*submitBtn.onclick = () => {
	account = createAccount();
	$.ajax({
		type: "put",
		url: "/app/profile/account/update",
		data: JSON.stringify(account),
		contentType: "application/json; charset=utf-8",
		dataTYpe: "text",
		success: function(data) {
			if (data == "true") {
				alert("회원정보 수정 완료");
				location.replace("/app/profile/account");
			} else {
				alert("이미 존재하는 사용자 이름입니다.");
			}
		},
		error: function() {
			alert("비동기 처리 오류");
		}
	})
}*/





















