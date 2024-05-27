
export const postUser = async ( newUser, serverUrl ) => {
    const url = `${serverUrl}/api/v1/users`;
    
    const options = {
        method: "POST", // POST, PUT, DELETE, GET
        headers: { "Content-Type":"application/json"},
        // headers: { "Content-Type":"application/json", Authorization: `Bearer ${token}` },
        body:  JSON.stringify( newUser )
    }

    const response = await fetch( url, options  );
    console.log( response )
    if (response.status === 201){
        const userCreated = await response.json();
        console.log( userCreated)
        alert("Usuario creado con éxito el " + userCreated.createdAt);
        localStorage.setItem("userData", JSON.stringify( newUser ) ); 

    }
} 






