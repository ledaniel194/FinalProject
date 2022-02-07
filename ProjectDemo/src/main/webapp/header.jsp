<header id="landingPage"
		style="background-image: url('image/room${cateId}.jpg'); height: 50vh;">
		<div class="landingPageContent">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-12 col-12">
						<h2>
							<c:if test="${cateId == 0}">
							Product Detail
							</c:if>
							${room.name}
						</h2>

					</div>
				</div>
			</div>
		</div>
	</header>