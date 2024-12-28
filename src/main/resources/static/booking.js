document.addEventListener('DOMContentLoaded', function () {
    const carList = document.getElementById('carList');

    carList.addEventListener('click', async function (event) {
        const target = event.target;
        if (target.tagName === 'BUTTON') {
            const carId = target.getAttribute('data-car-id');
            const userEmail = prompt('Enter your email to book this car:');
            if (userEmail) {
                try {
                    const response = await fetch('/api/rental/book');
                    if (response.ok) {
                        alert('Booking successful! An email confirmation has been sent.');
                    } else {
                        alert('Booking failed. Please try again.');
                    }
                } catch (error) {
                    console.error('Error booking car:', error);
                }
            }
        }
    });
});