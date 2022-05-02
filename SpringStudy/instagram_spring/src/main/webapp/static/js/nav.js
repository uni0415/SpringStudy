const profileImg = document.querySelector(".profile-img");
const bLogo = document.querySelector(".b-logo");

load();

function load() {
	profileImg.src = getProfileImg();
}

profileImg.onclick = () => {
	location.href = "/app/profile/account";
}

bLogo.onclick = () => {
	location.href = "/app/";
}