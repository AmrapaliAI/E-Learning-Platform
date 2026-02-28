
document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.menu-btn');
    const contentPanels = document.querySelectorAll('.content-panel');

    buttons.forEach(button => {
        button.addEventListener('click', () => {
            const targetId = button.getAttribute('data-content-id');
            
            // 1. Hide all content panels
            contentPanels.forEach(panel => {
                panel.classList.remove('active');
                panel.classList.add('hidden');
            });

            // 2. Deactivate all buttons
            buttons.forEach(btn => {
                btn.classList.remove('active');
            });

            // 3. Show the selected content panel and activate the button
            document.getElementById(targetId).classList.remove('hidden');
            document.getElementById(targetId).classList.add('active');
            button.classList.add('active');
        });
    });
});
/**
 * 
 */