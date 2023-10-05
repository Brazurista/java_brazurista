const btnMobile = document.getElementById('btn-mobile');

function toggleMenu(event) {
    if (event.type === 'touchstart') event.preventDefault();
        const nav = document.getElementById('nav');
        const body = document.body; 

        nav.classList.toggle('active');

        const active = nav.classList.contains('active');
        event.currentTarget.setAttribute('aria-expanded', active);

    if (active) {
        event.currentTarget.setAttribute('aria-label', 'Fechar Menu');
        
    } else {
        event.currentTarget.setAttribute('aria-label', 'Abrir Menu');
    }

    body.classList.toggle('nav-active');
}


btnMobile.addEventListener('click', toggleMenu);
btnMobile.addEventListener('touchstart', toggleMenu);