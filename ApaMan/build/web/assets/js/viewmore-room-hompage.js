function viewNoreRoom() {
    var dots = document.getElementById("nothing");
    var moreText = document.getElementById("showmore");
    var btnText = document.getElementById("buttonviewmoreroom");
  
    if (dots.style.display === "none") {
      dots.style.display = "inline";
      btnText.innerHTML = "Read more";
      moreText.style.display = "none";
    } else {
      dots.style.display = "none";
      btnText.innerHTML = "Read less";
      moreText.style.display = "inline";
    }
  }