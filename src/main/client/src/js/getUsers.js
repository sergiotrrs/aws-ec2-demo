
export const getUsers = async( serverUrl) => {
    const url = `${serverUrl}/api/v1/users`;
    
    try {
        const response = await fetch(url);
        const users = await response.json();        
        return users;
        
    } catch (error) {
        console.error( error );
    }

}