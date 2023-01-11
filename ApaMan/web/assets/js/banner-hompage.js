let slideIndex0 = 1;
showSlides0(slideIndex0);

// Next/previous controls
function plusSlides0(n) {
  showSlides0(slideIndex0 += n);
}

// Thumbnail image controls
function currentSlide0(n) {
  showSlides0(slideIndex0 = n);
}

function showSlides0(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides0");
  let dots = document.getElementsByClassName("dot0");
  if (n > slides.length) {slideIndex0 = 1}
  if (n < 1) {slideIndex0 = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex0-1].style.display = "block";
  dots[slideIndex0-1].className += " active";
}