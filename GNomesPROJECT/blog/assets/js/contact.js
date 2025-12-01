const mini = document.getElementById("miniRecommend");
let timeoutId = null;

mini.addEventListener("mouseenter", () => {
  if (timeoutId) {
    clearTimeout(timeoutId);
    timeoutId = null;
  }
  mini.classList.add("active");
});

mini.addEventListener("mouseleave", () => {
  timeoutId = setTimeout(() => {
    mini.classList.remove("active");
    timeoutId = null;
  }, 400);
});
