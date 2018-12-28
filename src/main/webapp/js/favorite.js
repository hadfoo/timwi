Vue.use(VueResource);

function onFavoriteLoaded(response) {
	new Vue({
		el: '#favorites',
		data : {
			album: null,
			currentList: response.body.data,
			favoriteList: response.body.data
		},
		methods: {
			filterAlbum: function() {
				if (!this.favoriteList) {
					return;
				}
				this.currentList = this.favoriteList.filter(fav => !this.album || this.album == fav.album);
			},
			removeFav: function(event) {
				var id = event.srcElement.getAttribute('data-id');
				this.$http.delete('/favorite/delete/'+this.id).then(function() {
					this.currentList = this.favoriteList =
						this.favoriteList.filter(fav => !this.album || this.album == fav.album);
				});
			}
		}
	});
}
this.Vue.http.get('/favorite/list').then(onFavoriteLoaded);