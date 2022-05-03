const profileImg = document.querySelector(".profile-img");
const bLogo = document.querySelector(".b-logo");

load();

function load() {
	//profileImg.src = getProfileImg();
}

profileImg.onclick = () => {
	location.href = "/gyeongun/profile/account";
}

bLogo.onclick = () => {
	location.href = "/gyeongun/";
}