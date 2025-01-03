console.log('Hello from script.js');

let currentTheme = getTheme();
console.log("Current theme: " + currentTheme);

changeTheme();

// TODO
function changeTheme() {
    changePageTheme(currentTheme, currentTheme);

    //set the listener for the theme switcher
    const changeThemeButton = document.querySelector('#theme_change_button');

    // Change the button text
    changeThemeButton.querySelector("span").textContent = 
    currentTheme == "light" ? "Dark" : "Light";

    changeThemeButton.addEventListener("click", () => {
        // Save the old theme
        const oldTheme = currentTheme;

        // Change the theme
        currentTheme = currentTheme === "light" ? "dark" : "light";

        // Apply the new theme
        changePageTheme(currentTheme, oldTheme);
    });
}

// Set theme to local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// Get theme from local storage
function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

function changePageTheme(theme, oldTheme) {
    // Set the new theme
    setTheme(theme);
        
    // Remove the old theme
    document.querySelector("html").classList.remove(oldTheme);

    // Add the new theme
    document.querySelector("html").classList.add(theme);

    // Update the button text
    document.querySelector('#theme_change_button').querySelector("span").textContent = 
    theme == "light" ? "Dark" : "Light";
}
