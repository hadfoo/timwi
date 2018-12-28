Vue.component('modal', {
	template: '#modal-template'
})
Vue.use(VueResource);

window.onload = function () {
	new Vue({
		el: '#heroes',
		data : {
			showModal: false,
			heroesList : [
				{
					id: 0,
					name : 'Captain America',
					thumbnail: '/img/0.jpg',
					description: 'Captain America est le super héro de l\'Amérique'
				},
				{
					id: 1,
					name : 'Thor',
					thumbnail: '/img/1.jpg',
					description: 'Thor est le dieu de la foudre'
				},
				{
					id: 2,
					name : 'Iron Man',
					thumbnail: '/img/2.jpg',
					description: 'Iron Man est le milliardaire philanthrope'
				}
			]
		},
		methods: {
			promptAlbum: function() {
				var id = event.srcElement.getAttribute('data-id');
				this.showModal = true;
				this.heroId = id;
			},
			addHero: function(event) {
				this.$http.put('/favorite/add/'+this.album+'/'+this.heroId);
			}
		}
	});
}