#include <iostream>
#include <unordered_map>
#include <list>
using namespace std;

class LRUCache
{
private:
  int capacity;
  list<pair<int, int>> cache; // doubly linked list to hold pairs in usage order i.e. most recently used at front, least recently used at back
  unordered_map<int, list<pair<int, int>>::iterator> map;

  void moveToFront(int key, int value)
  {
    cache.erase(map[key]);
    cache.push_front({key, value});
    map[key] = cache.begin();
  }

public:
  LRUCache(int capacity)
  {
    this->capacity = capacity;
  }

  int get(int key)
  {
    if (map.find(key) == map.end())
      return -1; // not in cache
    int value = map[key]->second;
    moveToFront(key, value);
    return value;
  }

  void put(int key, int value)
  {
    if (map.find(key) != map.end())
    {
      moveToFront(key, value);
    }
    else
    {
      if (cache.size() == capacity)
      {
        auto last = cache.back();
        map.erase(last.first);
        cache.pop_back();
      }
      cache.push_front({key, value});
      map[key] = cache.begin();
    }
  }
};

int main()
{
  LRUCache lru(2);
  lru.put(1, 1);
  lru.put(2, 2);
  cout << lru.get(1) << endl;
  lru.put(3, 3);
  cout << lru.get(2) << endl;
  lru.put(4, 4);
  cout << lru.get(1) << endl;
  cout << lru.get(3) << endl;
  cout << lru.get(4) << endl;
  return 0;
}
