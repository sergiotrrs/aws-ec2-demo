export const userDetails = (inputForm) => {
  const newUser = {
    firstName: inputForm.elements["firstName"].value,
    lastName: inputForm.elements["lastName"].value,
    email: inputForm.elements["email"].value,
    password: inputForm.elements["password"].value,
  };

  return newUser;
};
