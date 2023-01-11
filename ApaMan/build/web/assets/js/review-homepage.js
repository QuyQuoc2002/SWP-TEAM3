
const $$ = document.querySelectorAll.bind(document)

const carousel_rv = document.querySelector(".carousel_rv");
firstImg = carousel_rv.querySelectorAll("img")[0];
const arrowIcons = $$(".wrapper i");

let isDragStart = false, isDragging = false, prevPageX, prevScrollLeft, positionDiff;

const showHideIcons = () => {
    //showing and hiding prev/next icon according to carousel_rv scroll left value
    let scrollWidth = carousel_rv.scrollWidth - carousel_rv.clientWidth; // getting max scrollable width
    arrowIcons[0].style.display = carousel_rv.scrollLeft == 0 ? "none" : "block";
    arrowIcons[1].style.display = carousel_rv.scrollLeft == scrollWidth ? "none" : "block";
    
}

arrowIcons.forEach(icon => {
    icon.addEventListener("click", () => {
        let firstImgWidth = firstImg.clientWidth + 10; //getting first img width & adding 14 margin value
        // if clicked icon is left, reduce width value form the carousel_rv scroll left else add to it
       carousel_rv.scrollLeft += icon.id == "left" ? -firstImgWidth: firstImgWidth;
       setTimeout(() => showHideIcons(), 60);
    });
});

const autoSlide = () => {
    // if there is no img left to scroll then return here
    if(carousel_rv.scrollLeft == (carousel_rv.scrollWidth - carousel_rv.clientWidth)) return;

    positionDiff = Math.abs(positionDiff);
    let firstImgWidth = firstImg.clientWidth + 10;
    //getting difference value that needs to add or reuce from carousel_rv left to take middle imf center
    let valDifference = firstImgWidth - positionDiff;

    if (carousel_rv.scrollLeft > prevScrollLeft) { // scrolling to the right
        return carousel_rv.scrollLeft += positionDiff > firstImgWidth / 5 ? valDifference : -positionDiff
    } 
    //if user scrolling to the left
    carousel_rv.scrollLeft -= positionDiff > firstImgWidth / 5 ? valDifference : -positionDiff
}

const dragStart = (e) => {
    isDragStart = true;
    prevPageX = e.pageX || e.touches[0].pageX;
    prevScrollLeft = carousel_rv.scrollLeft;
}

const dragging = (e) => {
    // scrolling images/crousel to left according to mouse pointer
    if(!isDragStart) return;
    e.preventDefault();
    isDragging = true;
    carousel_rv.classList.add("dragging");
    positionDiff = (e.pageX || e.touches[0].pageX) - prevPageX;
    carousel_rv.scrollLeft = prevScrollLeft - positionDiff;
    showHideIcons()
}

const dragStop = () => {
    carousel_rv.classList.remove("dragging");
    isDragStart = false;

    if (!isDragging) return;
    isDragging = false
    autoSlide();
}

carousel_rv.addEventListener("mousedown", dragStart);
carousel_rv.addEventListener("touchstart", dragStart);

carousel_rv.addEventListener("mousemove", dragging);
carousel_rv.addEventListener("touchmove", dragging);

carousel_rv.addEventListener("mouseup", dragStop);
carousel_rv.addEventListener("mouseleave", dragStop);
carousel_rv.addEventListener("touchend", dragStop);