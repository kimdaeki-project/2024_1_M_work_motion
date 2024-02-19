const listTitle = document.querySelectorAll(".listTitle");
// const atag = document.getElementById("atag");

for(let i=0;i<listTitle.length;i++){
	listTitle[i].addEventListener("click", function(e){
	let href;
	 let child = e.target.childNodes
	 console.log(child);
	 for(let j=0;j<child.length;j++){
		href = child[j].href;
	 }
	 window.location.href = href;
	
	
	})
}
