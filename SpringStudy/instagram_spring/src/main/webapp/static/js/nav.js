const profileImg = document.querySelector(".profile-img");
const bLogo = document.querySelector(".b-logo");


profileImg.onclick = () => {
	location.href = "/app/account/profile";
}

bLogo.onclick = () => {
	location.href = "/app/";
}