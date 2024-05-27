
export const validateFormInput = ( newUser ) =>{
    let isValid = true;
    const messages = [];
    if( newUser.password.length < 5  ){
        isValid = false;
        messages.push("The password must be longer than five characters.");
    }
    if(!/^[a-zA-Z0-9]+$/.test(newUser.password) ){
        isValid = false;
        messages.push("The password must contain only letters and numbers.");
    }

    let alert = "";
    for (let message of messages ){
        alert += `<li>${message}</li>`
    }
    alert = `<ul>${alert}</ul>`
     console.log(alert);

    return {isValid, alert }; 
} 