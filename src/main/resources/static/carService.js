document.addEventListener('DOMContentLoaded', function () {
    const carList = document.getElementById('carList');
    const popup = document.getElementById('popup');

    fetchCarDetails();

    async function fetchCarDetails() {
        try {
            const response = await fetch('/api/rental/');
            const carDetails = await response.json();
            displayCarDetails(carDetails);
        } catch (error) {
            console.error('Error fetching car details:', error);
        }
    }

    function displayCarDetails(carDetails) {
        carList.innerHTML = '';
        carDetails.forEach(car => {
            const carItem = document.createElement('li');
            carItem.innerHTML = `<span>${car.carName}</span> - <span>${car.details}</span> - <span>${car.milege}</span> Mileage `;
            
            const bookButton = document.createElement('button');
            bookButton.textContent = 'Book';
            bookButton.addEventListener('click', async function() { 
				try {
		            const response = await fetch('/api/rental/id?carName=' + car.carName);
		            const carId = await response.text();
		            console.log(carId)
		            if (carId >= 0) {						
						window.location.href= 'book.html?id=' + carId
					} else {
						alert('Error fetching car id');
					}
		        } catch (error) {
		            alert('Error fetching car details:', error);
		        }
			 });
            carItem.appendChild(bookButton);

            carList.appendChild(carItem);
        });
    }

    function openPopup(carId) {
        popup.setAttribute('data-car-id', carId);

        popup.style.display = 'block';
    }
});