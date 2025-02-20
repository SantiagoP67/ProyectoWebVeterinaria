class Testimonial {
    constructor(text, name, image, rating, service, date) {
        this.text = this.formatText(text);
        this.name = name;
        this.image = image || "https://via.placeholder.com/60";
        this.rating = "⭐".repeat(rating);
        this.service = service;
        this.date = date || new Date().toLocaleDateString();
    }

    formatText(text) {
        return text.replace(/(\S{15,})/g, '$1- ');
    }
}

const testimonials = [
    new Testimonial(
        "Excellent service, very attentive to my pet!",
        "Peter Parker",
        "https://randomuser.me/api/portraits/men/10.jpg",
        5,
        "General Checkup",
        "January 15, 2024"
    ),
    new Testimonial(
        "The surgery went perfectly, and my dog recovered quickly!",
        "Walter White",
        "https://randomuser.me/api/portraits/men/20.jpg",
        4,
        "Surgery",
        "February 10, 2024"
    ),
    new Testimonial(
        "Amazing grooming services! My cat looks fabulous.",
        "Mary Jane",
        "https://randomuser.me/api/portraits/women/30.jpg",
        3,
        "Grooming",
        "March 5, 2024"
    )
];

function rebuildTestimonials() {
    const testimonialsContainer = document.querySelector(".testimonial-grid");
    testimonialsContainer.innerHTML = "";

    testimonials.forEach((testimonial) => {
        const testimonialCard = document.createElement("div");
        testimonialCard.className = "testimonial";
        testimonialCard.innerHTML = `
            <div class="testimonial-content">
                <img src="${testimonial.image}" alt="Client" />
                <div class="testimonial-text">
                    <p><strong>"${testimonial.text}</strong>"</p>
                    <p>- ${testimonial.name}</p>
                    <p class="stars">${testimonial.rating}</p>
                    <p class="testimonial-date">${testimonial.date}</p>
                    <p class="testimonial-service">Service: <strong>${testimonial.service}</strong></p>
                </div>
            </div>
        `;
        testimonialsContainer.appendChild(testimonialCard);
    });
}

document.addEventListener("DOMContentLoaded", () => {
    rebuildTestimonials();

    const stars = document.querySelectorAll(".star-rating span");
    const ratingInput = document.getElementById("user-rating");

    // Efecto de estrellas
    stars.forEach((star, index) => {
        star.addEventListener("mouseover", function () {
            stars.forEach((s, i) => {
                s.classList.toggle("active", i <= index);
            });
        });

        star.addEventListener("mouseout", function () {
            const selectedRating = parseInt(ratingInput.value) || 0;
            stars.forEach((s, i) => {
                s.classList.toggle("active", i < selectedRating);
            });
        });

        star.addEventListener("click", function () {
            let value = this.getAttribute("data-value");
            ratingInput.value = value;

            stars.forEach((s, i) => {
                s.classList.toggle("active", i < value);
            });
        });
    });

    document.getElementById("testimonial-form").addEventListener("submit", function (event) {
        event.preventDefault();

        const name = document.getElementById("user-name").value;
        const review = document.getElementById("user-review").value;
        const service = document.getElementById("user-service").value;
        const image = document.getElementById("user-image").value;
        const rating = parseInt(document.getElementById("user-rating").value);

        if (!rating) {
            alert("Please select a rating.");
            return;
        }

        const newTestimonial = new Testimonial(review, name, image, rating, service);
        testimonials.push(newTestimonial);

        rebuildTestimonials();
        this.reset();
        ratingInput.value = "";
        stars.forEach(s => s.classList.remove("active"));
    });
});