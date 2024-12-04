document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    
    if (!email || !password) {
        alert('Please fill in all fields.');
        return;
    }
    
    // Add further validation logic here
    alert('Login successful!');
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    let username = document.getElementById('username').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    
    if (!username || !email || !password) {
        alert('Please fill in all fields.');
        return;
    }
    
    // Add further validation logic here
    alert('Registration successful!');
});