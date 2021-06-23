import { HttpClient } from '@angular/common/http';
import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnInit, SimpleChange, SimpleChanges } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { convertToCategoryList } from 'src/app/conversion/conversion-from-rest';
import { vmGame, vmGameList, vmImage } from 'src/app/conversion/model';
import { categoryListRsrc, categoryRsrc } from 'src/app/conversion/restResource';
import { State } from 'src/app/store';
import { addGame } from 'src/app/store/gameStore/game.actions';

@Component({
  selector: 'app-add-page',
  templateUrl: './add-page.component.html',
  styleUrls: ['./add-page.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AddPageComponent implements OnInit {

  @Input() gamesList: vmGameList;
  @Input() game: vmGame;

  gameForm = this.formBuilder.group({
    category:'',
    title: '',
    subtitle: '',
    description: '',
    type: 1,
    author:'',
    replayBundleUrl: '',
    isStreamable: false,
    isDownloadable: false,
    version: '',

  })

  categories = [];
  images :vmImage[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private store: Store<State>,
    private httpClient: HttpClient,
    private cdk: ChangeDetectorRef
  ) { }

  ngOnInit() {
    this.gameForm = new FormGroup({
      title: new FormControl(this.game? this.game.title : null,[Validators.required, Validators.minLength(2)]),
      category: new FormControl(this.game? this.game.category: null),
      subtitle: new FormControl(this.game? this.game.subtitle: null),
      description: new FormControl(this.game? this.game.description: null),
      tags: new FormControl(this.game? this.game.tags: null), 
      imageurl: new FormControl(this.game? this.game.type: null),
      author: new FormControl(this.game? this.game.author: null),
      replayBundleUrl: new FormControl(this.game? this.game.replayBundleUrl: null),
      isStreamable: new FormControl(this.game? this.game.isStreamable: null),
      isDownloadable: new FormControl(this.game? this.game.isDownloadable: null),
      isPremium: new FormControl(this.game? this.game.isPremium: null)
    })

    this.httpClient.get("http://localhost:8080/categories").subscribe((data) => {
    let categoryRsrc =   data as categoryListRsrc;
    let categoryList = convertToCategoryList(categoryRsrc.categories);
      this.categories = categoryList.categories;
      console.log(data)
      this.cdk.detectChanges();
    })
  }

  ngOnChanges(changes: SimpleChanges) {
    if(changes.gamesList){
      this.gamesList = changes.gamesList.currentValue;
    }
  }

  onSubmit(): void {
    
    let game: vmGame = this.gameForm.value as vmGame;
    console.log(game)
    if(this.images.length != 0) {
      game.images = this.images;
    }
    this.store.dispatch(addGame(game));
    this.images = [];
    this.gameForm.reset();
  }

  addImageClicked() {
    console.log(this.gameForm.value.imageurl);
    let newImage : vmImage = {
      type: 1,
      url: this.gameForm.value.imageurl,
    }
    this.images.push(newImage);
    this.cdk.detectChanges();
  }

  removeLastImageClicked() {
    this.images = this.images.splice(0,1);
    this.cdk.detectChanges();
  }

  getImagesString() {
    let result = "";
    this.images.forEach((item) => {
      result += item.url+","
    })
    return this.images.length == 0? "" : result.substring(0,result.length-1);
  }

  get title() {return this.gameForm.get('title')!;}
  get type() {return this.gameForm.get('type')!;}

}
