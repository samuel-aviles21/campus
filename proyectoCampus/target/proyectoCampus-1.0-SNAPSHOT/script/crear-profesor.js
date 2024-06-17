document.getElementById('professor-form').addEventListener('submit', function(event) {
    event.preventDefault();
    document.getElementById('warning-modal').style.display = 'block';
});

document.getElementById('go-back').addEventListener('click', function() {
    document.getElementById('warning-modal').style.display = 'none';
});

document.getElementById('confirm-add').addEventListener('click', function() {
    document.getElementById('professor-form').submit();
});
