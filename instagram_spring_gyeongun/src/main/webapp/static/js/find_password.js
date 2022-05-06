const input = document.querySelectorAll("input");
const usernameInput = input[0];
const phoneInput = input[1];
const submitBtn = document.querySelector("button");


submitBtn.onclick = () => {
	$.ajax({
		type:"post",
		url:"/gyeongun/profile/find_password",
		data:{
			"username": usernameInput.value,
			"phone": phoneInput.value
		},
		dataType:"text",
		success(data){
			if(data == "true"){
				location.href="/gyeongun/profile/change_password";
			}
		},
		error(){
			alert("비동기 통신 오류");
		}
	})
}