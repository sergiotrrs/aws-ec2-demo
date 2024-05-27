
export const userCards = ( users  ) =>{

   const cards = users.map( (user)=> `
   <div class="col-6 col-md-3">
    <div class="card m-2">
        
        <div class="card-body">
            <h5 class="card-title">${user.firstName} ${user.lastName}</h5>
            <h6 class="card-subtitle mb-2 text-body-secondary">${user.email}</h6>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="${user.email}" class="btn btn-primary">E-mail</a>
        </div>
    </div>   
   </div>
   ` );


    document.getElementById("user-cards").innerHTML = cards.join("");

};