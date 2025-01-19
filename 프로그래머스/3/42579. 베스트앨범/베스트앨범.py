def solution(genres, plays):
    genres_dict = {}
    genre_total_plays = {}
    for idx, genre in enumerate(genres):
        if genre in genres_dict:
            genres_dict[genre].append((idx, plays[idx]))
        else:
            genres_dict[genre] = [(idx, plays[idx])]
        # 총 재생횟수 많은 장르 목록 구하기
        if genre in genre_total_plays:
            genre_total_plays[genre] += plays[idx]
        else:
            genre_total_plays[genre] = plays[idx]

    # 총 재생횟수 많은 순으로 정렬
    genre_total_plays = sorted(genre_total_plays.items(), key=lambda x: x[1], reverse=True)

    answer = []
    for genre, total_plays in genre_total_plays:
        sorted_genres_plays = sorted(genres_dict[genre], key=lambda x: x[1], reverse=True)
        cnt = 0
        for idx, play in sorted_genres_plays:
            cnt += 1
            if cnt > 2:
                break
            else:
                answer.append(idx)
    # 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
    return answer