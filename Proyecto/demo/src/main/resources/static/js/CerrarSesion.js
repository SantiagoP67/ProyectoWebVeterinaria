document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".dropdown");
    const menu = document.querySelector(".dropdown-menu");
  
    if (dropdown && menu) {
      dropdown.addEventListener("mouseenter", function () {
        menu.style.display = "block";
      });
  
      dropdown.addEventListener("mouseleave", function () {
        menu.style.display = "none";
      });
    }
  });
  