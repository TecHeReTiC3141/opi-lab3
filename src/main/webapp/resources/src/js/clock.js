updateDateTime();
setInterval(updateDateTime, 1000);

function updateDateTime() {
  const now = new Date();
  const dateString = now.toLocaleDateString(undefined, { day: 'numeric', month: 'short', year: 'numeric' });
  const timeString = now.toLocaleTimeString(undefined, { hour: '2-digit', minute: '2-digit', second: '2-digit' });

  $("#date").text(dateString);
  $("#time").text(timeString);

  $("#date-mobile").text(dateString);
  $("#time-mobile").text(timeString);
}
